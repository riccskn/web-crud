import React, {useEffect, useState} from "react";
import '../App.css'
import NavBar from "../components/NavBar";
import {IoPersonAdd} from "react-icons/io5"
import TableData from "../components/TableData";
import UserService from "../service/api_service";
import {IUser} from "../types";
import { useNavigate } from "react-router-dom";

export default function Home() {

    const [users,setUsers] = useState([])
    const [showingAddModal, setShowingAddModal] = useState(false)

    const navigate = useNavigate()

    const handleClickButton = () => {
       navigate("/register")
    }

    const service = new UserService();

    const getUsers = async () => {

        const res = await service.findAll();
        setUsers(res.data)


        console.log("Delay")

    }

    useEffect(() => {

     getUsers().then(value => console.log(users))

    },[])

  return (
         <>
         <NavBar/>

           <div id={"table-data"}>

           <table>
           <th>Nome</th>
           <th>Apelido</th>
           <th>Telefone</th>
           <th className={"fake-column"}>Email</th>

               {users && users.map((user: IUser) => {
                   return <TableData user={user}/>
               })}

           </table>

          </div>


        <button onClick={event => handleClickButton()} id={"btn-create"}><IoPersonAdd/>Add</button>

   </>
  )
}