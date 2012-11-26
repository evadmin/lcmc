/*
 * This file is part of LCMC
 *
 * Copyright (C) 2012, Rastislav Levrinc.
 *
 * LCMC is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * DRBD Management Console is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with drbd; see the file COPYING.  If not, write to
 * the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package lcmc.gui;

import lcmc.utilities.Tools;
import lcmc.utilities.Unit;
import lcmc.utilities.PatternDocument;
import lcmc.data.ConfigData;
import lcmc.data.AccessMode;
import lcmc.gui.resources.Info;
import lcmc.utilities.MyButton;
import lcmc.utilities.WidgetListener;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.text.JTextComponent;
import javax.swing.text.Document;
import javax.swing.text.AbstractDocument;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.Box;
import javax.swing.ComboBoxEditor;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentListener;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;

import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.Component;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * An implementation of a field where user can enter new value. The
 * field can be Textfield or combo box, depending if there are values
 * too choose from.
 *
 * @author Rasto Levrinc
 * @version $Id$
 *
 */
public final class Label extends Widget {
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;
    /** Label of this component. */
    private JLabel label = null;

    /** Prepares a new <code>Widget</code> object. */
    public Widget(final String selectedValue,
                  final Object[] items,
                  final Unit[] units,
                  final Type type,
                  final String regexp,
                  final int width,
                  final Map<String, String> abbreviations,
                  final AccessMode enableAccessMode,
                  final MyButton fieldButton) {
        super();
        newComp = getLabelField(selectedValue);
        processAccessMode();
    }

    /** Returns whether this field is a check box. */
    @Override
    public boolean isCheckBox() {
        return false;
    }

    /** Returns new MTextField with default value. */
    private JComponent getLabelField(final String value) {
        return new JLabel(value);
    }

    @Override
    public void setToolTipText(String text) {
        toolTipText = text;
        final String disabledReason0 = disabledReason;
        if (disabledReason0 != null) {
            text = text + "<br>" + disabledReason0;
        }
        if (enableAccessMode.getAccessType() != ConfigData.AccessType.NEVER) {
            final boolean accessible =
                     Tools.getConfigData().isAccessible(enableAccessMode);
            if (!accessible) {
                text = text + "<br>" + getDisabledTooltip();
            }
        }
        component.setToolTipText("<html>" + text + "</html>");
    }

    /** Sets combo box editable. */
    @Override
    public void setEditable(final boolean editable) {
    }

    /**
     * Returns string value. If object value is null, returns empty string (not
     * null).
     */
    @Override
    public String getStringValue() {
        return o.toString();
    }

    /** Returns value, that use chose in the combo box or typed in. */
    @Override
    public Object getValue() {
        value = ((JLabel) comp).getText();
        return value;
    }

    /** Clears the combo box. */
    @Override
    public void clear() {
    }

    /** Returns whether component is editable or not. */
    @Override
    boolean isEditable() {
        return false;
    }

    /** Sets item/value in the component and waits till it is set. */
    private void setValueAndWait0(final Object item) {
        mValueWriteLock.lock();
        ((JLabel) comp).setText((String) item);
        mValueWriteLock.unlock();
    }

    /** Sets selected index. */
    @Override
    public void setSelectedIndex(final int index) {
    }

    /** Returns document object of the component. */
    @Override
    public Document getDocument() {
        return null;
    }

    /** Selects part after first '*' in the ip. */
    @Override
    public void selectSubnet() {
        case LABELFIELD:
    }

    @Override
    public void addListeners(final WidgetListener wl) {
        widgetListeners.add(wl);
        JComponent comp;
        if (fieldButton == null) {
            comp = component;
        } else {
            comp = componentPart;
        }
    }

    /**
     * Sets background of the component depending if the value is the same
     * as its default value and if it is a required argument.
     * Must be called after combo box was already added to some panel.
     *
     * It also disables, hides the component depending on the access type.
     * TODO: rename the function
     */
    public void setBackground(final String defaultLabel,
                              final Object defaultValue,
                              final String savedLabel,
                              final Object savedValue,
                              final boolean required) {
        if (getParent() == null) {
            return;
        }
        JComponent comp;
        if (fieldButton == null) {
            comp = component;
        } else {
            comp = componentPart;
        }
        final Object value = getValue();
        String labelText = null;
        if (savedLabel != null) {
            labelText = label.getText();
        }

        final Color backgroundColor = getParent().getBackground();
        final Color compColor = Color.WHITE;
        if (!Tools.areEqual(value, savedValue)
            || (savedLabel != null && !Tools.areEqual(labelText, savedLabel))) {
            if (label != null) {
                Tools.debug(this, "changed label: " + labelText + " != "
                                   + savedLabel, 1);
                Tools.debug(this, "changed: " + value + " != "
                                         + savedValue, 1);
                /*
                   Tools.printStackTrace("changed: " + value + " != "
                                         + savedValue);
                 */
                label.setForeground(CHANGED_VALUE_COLOR);
            }
        } else if (Tools.areEqual(value, defaultValue)
                   && (savedLabel == null
                       || Tools.areEqual(labelText, defaultLabel))) {
            if (label != null) {
                label.setForeground(DEFAULT_VALUE_COLOR);
            }
        } else {
            if (label != null) {
                label.setForeground(SAVED_VALUE_COLOR);
            }
        }
        setBackground(backgroundColor);
        switch(type) {
            case LABELFIELD:
                comp.setBackground(backgroundColor);
                break;
            case TEXTFIELD:
                /* change color possibly set by wrongValue() */
                comp.setBackground(compColor);
                break;
            case PASSWDFIELD:
                comp.setBackground(compColor);
                break;
            case COMBOBOX:
                setBackground(Color.WHITE);
                break;
            case RADIOGROUP:
                comp.setBackground(backgroundColor);
                mComponentsReadLock.lock();
                for (final JComponent c : componentsHash.values()) {
                    c.setBackground(backgroundColor);
                }
                mComponentsReadLock.unlock();
                break;
            case CHECKBOX:
                comp.setBackground(backgroundColor);
                break;
            case TEXTFIELDWITHUNIT:
                textFieldPart.setBackground(Color.WHITE);
                break;
            default:
                /* error */
        }
        processAccessMode();
    }

    /** Requests focus if applicable. */
    @Override
    public void requestFocus() {
    }

    /** Selects the whole text in the widget if applicable. */
    @Override
    void selectAll() {
    }

    /** Sets background color. */
    @Override
    public void setBackgroundColor(final Color bg) {
        comp.setBackground(bg);
    }

    /** Returns item at the specified index. */
    @Override
    Object getItemAt(final int i) {
        return component;
    }

    /** Cleanup whatever would cause a leak. */
    @Override
    public void cleanup() {
    }
}
