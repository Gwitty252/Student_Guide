package io.gideon.studentguide.viewmodels

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

import dagger.hilt.android.lifecycle.HiltViewModel
import io.gideon.studentguide.data.User
import io.gideon.studentguide.utils.*
import io.gideon.studentguide.utils.Constants.USER_COLLECTION
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val auth: FirebaseAuth,
                                            private val db: FirebaseFirestore
) :ViewModel() {
    private val _register = MutableStateFlow<Resource<User>>(Resource.Unspecified())
    val register: Flow<Resource<User>> = _register

    private val _validation = Channel<RegisterFieldsState>()
    val validation = _validation.receiveAsFlow()

    fun registerUserWithEmailAndPassword(users: User, accessCode:String){

        if (checkValidation(users, accessCode)) {
            runBlocking {
                _register.emit(Resource.Loading())
            }
            auth.createUserWithEmailAndPassword(users.email,accessCode)
                .addOnSuccessListener {
                    it.user?.let {
                        saveUserInfo(it.uid, users)
                    }
                }.addOnFailureListener {
                    _register.value = Resource.Error(it.message.toString())
                }
        } else {
            val registerFieldsState = RegisterFieldsState(
                validateEmail(users.email), validateAccessCode(accessCode)
            )
            runBlocking {
                _validation.send(registerFieldsState)
            }
        }
    }

    private fun saveUserInfo(userUid: String, user: User) {
        db.collection(USER_COLLECTION)
            .document(userUid)
            .set(user)
            .addOnSuccessListener {
                _register.value = Resource.Success(user)
            }.addOnFailureListener {
                _register.value = Resource.Error(it.message.toString())
            }
    }

    private fun checkValidation(user: User, accessCode: String, ): Boolean {
       val confirmAccessCode:String = ""
        val emailValidation = validateEmail(user.email)
        val passwordValidation = validateAccessCode(accessCode)
        val firstNameValidation = validateFirstName(user.firstName)
        val lastName = validateLastName(user.lastName)
        val phoneValidation = validatePhoneNumber(user.phone)
        val confirmAccessCodeValidation = checkConfirmAccessCode(confirmAccessCode)
        val regNumberValidation = validateRegNumber(user.regNumber)
        val shouldRegister = emailValidation is RegisterValidation.Success &&
                passwordValidation is RegisterValidation.Success && firstNameValidation is RegisterValidation.Success
                && lastName is RegisterValidation.Success && regNumberValidation is RegisterValidation.Success
                && phoneValidation is RegisterValidation.Success

        return shouldRegister
    }
}