import React from "react";
import {TbEdit} from "react-icons/tb";
import {TiDeleteOutline} from "react-icons/ti";
import {IUser} from "../../types";
import "./styles/index.css"
import UserService from "../../service/api_service";
import {useNavigate} from "react-router-dom";



export default function TableData(props:{user:IUser}) {

    const navigate = useNavigate()

    const service = new UserService()

   const handleEditClick = (id: number) => {
          window.alert("User id: "+id+" editado")
   }


    const handleDeleteClick = (id: number) => {

       service.delete(id)
           .then(value => navigate("/"))

    }

    return (
        <tr>
            <td>{props.user.name}</td>
            <td>{props.user.nickname}</td>
            <td>{props.user.phone}</td>
            <td>{props.user.email}</td>
            <td><button onClick={event => handleEditClick(props.user.id)} className={"action-btn"} id={"edit-btn"}><TbEdit size={18}/><a>Edit</a></button></td>
            <td><button onClick={event => handleDeleteClick(props.user.id)} className={"action-btn"} id={"delete-btn"}><TiDeleteOutline size={18}/><a>Delete</a></button></td>
        </tr>
    )

}