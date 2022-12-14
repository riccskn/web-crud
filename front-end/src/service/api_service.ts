import api from "./api";
import {IUserDTO} from "../types";


export default class UserService {

    findAll() {
       return api.get("/users")
    }

    findById(id: number) {
      return api.get("/users/"+id)
    }

    create(name: string,nickname: string,email: string,phone: string) {

        let entity: IUserDTO = {
            name: name,
            nickname: nickname,
            email: email,
            phone: phone
        }

        return api.post("/users",entity)
    }

    delete(id: number) {
        return api.delete("/users/"+id)
    }



}