import React, {useState} from "react";
import NavBar from "../components/NavBar";
import {FaUserAlt} from "react-icons/fa"
import {BsFillTelephoneFill} from "react-icons/bs"
import {MdEmail} from "react-icons/md"
import "../App.css"
import UserService from "../service/api_service";
import {useNavigate} from "react-router-dom";

export default function Register() {

    const [name,setName] = useState("")
    const [nickname,setNickname] = useState("")
    const [email,setEmail] = useState("")
    const [phone,setPhone] = useState("")

    const service = new UserService()

    const navigate = useNavigate()

    const handleButtonClick = () => {

        service.create(name,nickname,email,phone)
            .then(value => navigate("/"))
            .catch()

    }

   return (
       <>
       <NavBar/>

           <h1 id={"pg-title"}>Add new user</h1>

           <section id={"form-area"}>

               <form>

                 <div className={"input-row"}>
                     <FaUserAlt/>
                     <input onChange={event => setName(event.target.value)} type={"text"} placeholder={"Name"}/>
                 </div>

                   <div className={"input-row"}>

                       <input onChange={event => setNickname(event.target.value)} id={"no-icon"} type={"text"} placeholder={"Nickname"}/>
                   </div>


                   <div className={"input-row"}>
                       <BsFillTelephoneFill/>
                       <input onChange={event => setPhone(event.target.value)} type={"tel"} placeholder={"Phone number"}/>
                   </div>

                   <div className={"input-row"}>
                       <MdEmail/>
                       <input onChange={event => setEmail(event.target.value)} type={"email"} placeholder={"Email"}/>
                   </div>


               </form>

               <button onClick={event => handleButtonClick()} type={"submit"} id={"save-btn"}>Salvar</button>

           </section>

       </>
   )
}