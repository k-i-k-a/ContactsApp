package com.kika.contactsapp.data

import com.kika.contactsapp.R
import com.kika.contactsapp.model.Contacts

class DataSource {
    fun loadContacts(): List<Contacts> {
        val contacts= mutableListOf<Contacts>()
        contacts.add(
            Contacts(
                name = R.string.name1,
                phone = R.string.phone1,
                image = R.drawable.auntie
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name2,
                phone = R.string.phone2,
                image = R.drawable.brother
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name3,
                phone = R.string.phone3,
                image = R.drawable.daughter
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name4,
                phone = R.string.phone4,
                image = R.drawable.friend_1
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name5,
                phone = R.string.phone5,
                image = R.drawable.friend_2
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name6,
                phone = R.string.phone6,
                image = R.drawable.grandfather
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name7,
                phone = R.string.phone7,
                image = R.drawable.granny
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name8,
                phone = R.string.phone8,
                image = R.drawable.neigbour
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name9,
                phone = R.string.phone9,
                image = R.drawable.sister
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name10,
                phone = R.string.phone10,
                image = R.drawable.son
            )
        )
        contacts.add(
            Contacts(
                name = R.string.name11,
                phone = R.string.phone11,
                image = R.drawable.uncle
            )
        )
        return contacts
    }
}