package com.eugene.student_assistant.models

import com.google.firebase.database.Exclude

data class User (val fullName: String="", val admNumber: String="", val email: String="",
                 val photo: String? = null, @Exclude val uid: String ="")