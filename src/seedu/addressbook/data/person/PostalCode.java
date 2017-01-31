package seedu.addressbook.data.person;

public class PostalCode {
    private int _value;
    
    public PostalCode(int block) {
        this._value = block;
    }

    private int get_value() {
        return _value;
    }

    private void set_value(int _value) {
        this._value = _value;
    }
}
