package com.example.homework3lesson4
import java.io.Serializable
data class User(var firstName:String?, var lastName:String?, var email:String?, var password:String?):
    Serializable{
    override fun toString(): String {
        return "User(firstName=$firstName, lastName=$lastName, email=$email, password=$password)"
    }
    }
