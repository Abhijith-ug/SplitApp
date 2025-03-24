package com.example.splitapp.data.repository

import android.content.ContentResolver
import android.provider.ContactsContract
import android.util.Log
import com.example.splitapp.domain.ContactModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactRepository(private val contentResolver: ContentResolver) {
    fun getContacts(): Flow<List<ContactModel>> = flow {

        val contacts = getPhoneContacts()
        emit(contacts.toList().distinctBy {
            it.id
        })
    }


    private  fun getPhoneContacts(): ArrayList<ContactModel> {
        val contactsList = ArrayList<ContactModel>()
        val contactsCursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        Log.d("sdfsfsdf", "getPhoneContacts:  ${contactsCursor?.count}")

        if (contactsCursor != null && contactsCursor.count > 0) {
            Log.d("sdfsfsdf", "getPhoneContacts:  ${ContactsContract.Contacts.DISPLAY_NAME}")
            val idIndex = contactsCursor.getColumnIndex(ContactsContract.Contacts._ID)
            val nameIndex = contactsCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
            val imageIndex =
                contactsCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI)
            while (contactsCursor.moveToNext()) {
                val id = contactsCursor.getString(idIndex)
                val name = contactsCursor.getString(nameIndex)

                val image = contactsCursor.getString(imageIndex)
                if (name != null) {
                    contactsList.add(ContactModel( name = name, image =  image, id = id))
                }
            }
            contactsCursor.close()
        }
        Log.d("ColumnIndex", "Name Index: $contactsList")

        return contactsList
    }
}