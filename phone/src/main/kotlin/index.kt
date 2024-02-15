data class Contact(val name: String, val phoneNumber: String)
class MobilePhone(private val myNumber: String) {
    private val myContacts = mutableListOf<Contact>()
    fun addNewContact(contact: Contact): Boolean {
        if (findContact(contact) >= 0) {
            return false
        }
        myContacts.add(contact)
        return true
    }
    fun updateContact(oldContact: Contact, newContact: Contact): Boolean{
        val position = findContact(oldContact)
        if (position >= 0){
            myContacts[position] = newContact
            return true
        }
        return false
    }
    fun removeContact(Contact: Contact): Boolean{
        val position = findContact(Contact)
        if (position >= 0){
            myContacts.removeAt(position)
            return true
        }
        return false
    }
    fun findContact(Contact: Contact): Int {
        return myContacts.indexOf(Contact)
    }
    fun queryContact(name: String): Contact? {
        for (contact in myContacts) {
            if (contact.name == name) {
                return contact
            }
        }
        return null
    }
    fun printContacts() {
        for (contact in myContacts) {
            println(contact)
        }
    }
}
fun main() {
    val mobilePhone = MobilePhone("1234567890")
    val contact1 = Contact("John", "11111111111")
    val contact2 = Contact("Sergey", "89132906298")
    val contact3 = Contact("Bob", "3333333333")
    mobilePhone.addNewContact(contact1)
    mobilePhone.addNewContact(contact2)
    mobilePhone.addNewContact(contact3)

    mobilePhone.printContacts()

    val newContact2 = Contact("John Doe", "11111111111")
    mobilePhone.updateContact(contact2, newContact2)

    mobilePhone.removeContact(contact3)

    val foundContact = mobilePhone.queryContact("Sergey")
    println(foundContact)

    mobilePhone.printContacts()
}