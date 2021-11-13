package rest.addressbook

import java.net.URI


/**
 * A really simple Address Book. This class is not thread safe.
 */
class AddressBook {
    /**
     * The value of next unique identifier.
     *
     * @return the next unique identifier.
     */
    var nextId = 1

    /**
     * The list of persons in this address book.
     *
     * @return a person list.
     */
    var personList: MutableList<Person> = mutableListOf()
    /**
     * Returns the old next identifier and increases the new value in one.
     *
     * @return an identifier.
     */
    fun nextId(): Int {
        val oldValue = nextId
        nextId++
        return oldValue
    }

    fun clear() {
        nextId = 1
        personList = mutableListOf()
    }

    fun copy(): AddressBook {
        var addressBookCopy: AddressBook = AddressBook()
        addressBookCopy.nextId = this.nextId
        addressBookCopy.personList = this.personList
        return addressBookCopy
    }
}

data class Person(
    var id: Int = 0,
    var name: String,
    var email: String? = null,
    var href: URI? = null,
    var phoneList: List<PhoneNumber> = emptyList()
) {
    fun hasEmail() = email != null
}

data class PhoneNumber(
    val number: String,
    val type: PhoneType = PhoneType.HOME
)

enum class PhoneType {
    MOBILE, HOME, WORK
}