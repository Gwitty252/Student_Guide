package io.gideon.studentguide.data


data class User(
val firstName:String,
val lastName:String,
val phone:String,
val email:String,
var imagePath:String = "",
var middleName : String = "",
val regNumber: String
){
    constructor() :this("","","","","", "","")
}
