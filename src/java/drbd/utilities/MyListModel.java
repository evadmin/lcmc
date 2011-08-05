/*
 * This file is part of DRBD Management Console by LINBIT HA-Solutions GmbH
 * by Rasto Levrinc.
 *
 * Copyright (C) 2009, Rastislav Levrinc
 * Copyright (C) 2009, LINBIT HA-Solutions GmbH.
 *
 * DRBD Management Console is free software; you can redistribute it and/or
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

package drbd.utilities;

import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.SwingUtilities;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

/**
 * A ListModel with filtered items.
 */
public final class MyListModel extends AbstractListModel {
    /** Serial version UID. */
    private static final long serialVersionUID = 1L;

    private final List<MyMenuItem> items = new ArrayList<MyMenuItem>();
    private final List<MyMenuItem> filteredItems = new ArrayList<MyMenuItem>();
    private static final String START_TEXT = "type to search...";
    private final FilterField filterField = new FilterField(START_TEXT);
    /** Prepares a new <code>MyListModel</code> object. */
    public MyListModel() {
        super();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                filterField.selectAll();
            }
        });
    }

    public FilterField getFilterField() {
        return filterField;
    }

    public Object getElementAt(final int index) {
        if (index < filteredItems.size()) {
            return filteredItems.get(index);
        } else {
            return null;
        }
    }

    public int getSize() {
        return filteredItems.size();
    }

    public void addElement(final Object o) {
        items.add((MyMenuItem) o);
        refilter();
    }

    private void refilter() {
        filteredItems.clear();
        String filter = filterField.getText();
        if (START_TEXT.equals(filter)) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    filterField.selectAll();
                }
            });
            filter = "";
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).toString().toLowerCase(Locale.US).indexOf(
                                        filter.toLowerCase(Locale.US)) >= 0) {
                filteredItems.add(items.get(i));
            }
        }
        fireContentsChanged(this, 0, getSize());
    }

    private class FilterField extends JTextField implements DocumentListener {
        /** Serial version UID. */
        private static final long serialVersionUID = 1L;
        public FilterField(final String text) {
            super(text);
            getDocument().addDocumentListener(this);
        }

        public void changedUpdate(final DocumentEvent e) {
            refilter();
        }

        public void insertUpdate(final DocumentEvent e) {
            refilter();
        }

        public void removeUpdate(final DocumentEvent e) {
            refilter();
        }
    }
}
