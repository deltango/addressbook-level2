package seedu.addressbook.data.person;

public class PostalCode {
    private int _value;
    
    public PostalCode(int block) {
        this._value = block;
    }

    public int get_value() {
        return _value;
    }

    public void set_value(int _value) {
        this._value = _value;
    }
}
