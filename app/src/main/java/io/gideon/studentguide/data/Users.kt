package io.gideon.studentguide.data

data class Users(
val firstName:String,
val lastName:String,
val phone:String,
val email:String,
val imagePath:String = ""
){
    constructor():this("","","","","")
}
