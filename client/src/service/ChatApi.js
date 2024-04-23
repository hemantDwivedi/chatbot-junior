import axios from "axios"

const BASE_URL = "http://localhost:8080/api/chats"

export const chatWithAi = (Query) => axios.post(BASE_URL, Query)
export const allChatsApi = () => axios.get(BASE_URL) // GET, All chats