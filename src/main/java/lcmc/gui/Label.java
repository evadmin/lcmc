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
    public Label(final String selectedValue,
                 final Object[] items,
                 final Unit[] units,
                 final Type type,
                 final String regexp,
                 final int width,
                 final Map<String, String> abbreviations,
                 final AccessMode enableAccessMode,
                 final MyButton fieldButton) {
        super(selectedValue,
              items,
              units,
              type,
              regexp,
              width,
              abbreviations,
              enableAccessMode,
              fieldButton);
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
        final Object o = getValue();
        if (o == null) {
            return "";
        }
        return getValue().toString();
    }

    /** Returns value, that use chose in the combo box or typed in. */
    @Override
    public Object getValue() {
        return ((JLabel) getComponent()).getText();
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
    }

    @Override
    public void addListeners(final WidgetListener wl) {
        getWidgetListeners().add(wl);
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
        getComponent().setBackground(bg);
    }

    /** Returns item at the specified index. */
    @Override
    Object getItemAt(final int i) {
        return getComponent();
    }

    /** Cleanup whatever would cause a leak. */
    @Override
    public void cleanup() {
    }
}
