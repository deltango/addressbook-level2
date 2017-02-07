package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    public final String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate,
            String messageContactConstraints, String contactValidationRegex)
            throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = value.trim();
        if (!isValidContact(trimmedContact, contactValidationRegex)) {
            throw new IllegalValueException(messageContactConstraints);
        }
        this.value = trimmedContact;
    }

    /**
     * Checks if a given string is a valid Contact.
     */
    public static boolean isValidContact(String test,
            String contactValidationRegex) {
        return test.matches(contactValidationRegex);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}