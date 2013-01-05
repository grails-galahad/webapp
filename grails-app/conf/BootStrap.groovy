import com.webapp.*

class BootStrap {

    def init = { servletContext ->
        new Person(firstName:"Ron", lastName:"Burgundy", email:"ronb@kvwn.net", dateOfBirth:Date.parse("yyyy-MM-dd'T'HH:mm:ssz", "1935-07-17T00:00:00EST"),
                address:new Address(address1:'123 Street Rd.', address2:'Apt. 1A', city:'San Diego', postCode:'92101')).save(flush:true, failOnError:true)
        new Person(firstName:"Brian", lastName:"Fantana", email:"brianf@kvwn.net", dateOfBirth:Date.parse("yyyy-MM-dd'T'HH:mm:ssz", "1935-07-17T00:00:00EST"),
                address:new Address(address1:'123 Street Rd.', address2:'Apt. 1B', city:'San Diego', postCode:'92101')).save(flush:true, failOnError:true)
        new Person(firstName:"Brick", lastName:"Tamland", email:"brickt@kvwn.net", dateOfBirth:Date.parse("yyyy-MM-dd'T'HH:mm:ssz", "1935-07-17T00:00:00EST"),
                address:new Address(address1:'123 Street Rd.', address2:'Apt. 1C', city:'San Diego', postCode:'92101')).save(flush:true, failOnError:true)
    }
    def destroy = {
    }
}
