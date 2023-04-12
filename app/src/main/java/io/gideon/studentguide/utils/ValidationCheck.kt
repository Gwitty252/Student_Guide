package io.gideon.studentguide.utils

import android.util.Patterns

fun validateEmail(email: String): RegisterValidation{
    if (email.isEmpty())
        return RegisterValidation.Failed("Email cannot be empty")

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        return RegisterValidation.Failed("Wrong email format")

    return RegisterValidation.Success
}

fun validateAccessCode(accessCode: String): RegisterValidation{
    if (accessCode.isEmpty())
        return RegisterValidation.Failed("Password cannot be empty")

    if (accessCode.length < 6)
        return RegisterValidation.Failed("Password should contains 6 char")

    return RegisterValidation.Success
}
fun validateFirstName(firstName:String): RegisterValidation {
    if (firstName.isEmpty()) return RegisterValidation.Failed("First Name Field is required")

    return RegisterValidation.Success
}
fun validateLastName(lastName:String):RegisterValidation{
    if (lastName.isEmpty()) return RegisterValidation.Failed("Last Name is required")


    return RegisterValidation.Success
}
fun validatePhoneNumber(phone:String):RegisterValidation{
    if (phone.isEmpty())return RegisterValidation.Failed("Phone number field is required")
    if (phone.length<11) return RegisterValidation.Failed("Phone number must be more than 10 char")
    return RegisterValidation.Success
}

fun checkConfirmAccessCode(confirmAccessCode:String):RegisterValidation{

    if (confirmAccessCode.isEmpty()) return RegisterValidation.Failed("Confirm You password to continue")
    if (!confirmAccessCode.equals(6))return RegisterValidation.Failed("Access code should match")
    return RegisterValidation.Success
}

fun validateRegNumber(regNumber:String):RegisterValidation{
    if (regNumber.isEmpty())return  RegisterValidation.Failed("Input correct Registration number")
    return  RegisterValidation.Success
}