package com.kika.contactsapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Contacts(
    @StringRes val name: Int,
    @StringRes val phone: Int,
    @DrawableRes val image: Int
    )
