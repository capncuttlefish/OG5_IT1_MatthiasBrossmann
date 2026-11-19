package de.promocode.gui;

import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberTextField extends JTextField {

	public NumberTextField() {
		super(12);
		((AbstractDocument) getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr)
					throws BadLocationException {
				if (text != null && text.matches("[0-9]*")) {
					super.insertString(fb, offset, text, attr);
				}
			}

			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				if (text == null || text.matches("[0-9]*")) {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});
	}

	public Long getNumber() {
		long number;
		try {
			number = Long.parseLong(this.getText());
		} catch (NumberFormatException e) {
			number = 0L;
		}
		return number;
	}
}
