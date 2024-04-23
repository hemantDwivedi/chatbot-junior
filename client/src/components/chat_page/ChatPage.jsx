import 'regenerator-runtime/runtime'
import SpeechRecognition, { useSpeechRecognition } from 'react-speech-recognition'
import { useEffect, useState } from "react";
import ChatHistory from "../chat_history/ChatHistory";
import { allChatsApi, chatWithAi } from "../../service/ChatApi";

const ChatPage = () => {

    const startListening = () => SpeechRecognition.startListening({ continuous: true, language: 'en-IN' })
    const { transcript, listening, browserSupportsSpeechRecognition } = useSpeechRecognition()
    const { resetTranscript } = useSpeechRecognition()


    if (!browserSupportsSpeechRecognition) {
        return null
    }

    const [query, setQuery] = useState('')
    const [chatbotAnswer, setChatbotAnswer] = useState('')
    const [chats, setChats] = useState()

    useEffect(() => {
        allChatsApi()
            .then(response => setChats(response.data))
            .catch(error => console.error(error))
    }, [])


    function handleUserQuery() {

        if (transcript.trim == '') console.log('empty');

        console.log("chats", chats);

        setQuery(transcript);
        console.log(query);
        callChatApi(transcript)
    }

    function callChatApi(Query) {
        console.log(Query);

        chatWithAi({ Query })
            .then(response => setChatbotAnswer(response.data.Answer))
            // .then(response => console.log(response.data.Answer))
            .catch(error => console.error(error))
    }

    return (
        <div>
            <div className="flex h-screen bg-neutral-950 text-white">
                <div className="">
                </div>
                <div className="flex-1 flex flex-col">
                    <header className="text-gray-600 py-4 px-6 flex justify-end">
                        <button className="text-sm p-2.5 border-2 border-gray-800 rounded-full hover:bg-violet-800 hover:text-white">
                            Sign out
                        </button>
                    </header>
                    <main className="flex-1 p-4">
                        {
                            chats === 0 &&
                            <div className="uppercase text-gray-800 font-bold content-center grid justify-center text-4xl h-full">
                                chatbot junior
                                <p className="text-sm capitalize text-center">How can I assist you today?</p>
                            </div>
                        }
                        <div className="flex flex-col h-full max-w-3xl mx-auto">
                            {/* {
                                chats.map((chat) => (
                                    <><div>
                                        chat.Query
                                    </div>
                                        <div>
                                            chat.Answer
                                        </div>
                                    </>
                                ))
                            } */}
                            {/* <div className="overflow-y-auto flex-1">
                                <div className="flex gap-3 mb-2">
                                    <img className="w-8 h-8 my-auto" src="https://img.icons8.com/nolan/64/user.png" alt="user" />
                                    <div className="py-2 max-w-2xl">
                                        {query}
                                    </div>
                                </div>
                                <div className="flex my-3 gap-3">
                                    <img
                                        src="https://img.icons8.com/nolan/64/artificial-intelligence.png"
                                        alt="artificial-intelligence"
                                        className="w-8 h-8"
                                    />
                                    <div className="py-2 w-full">
                                        {
                                            chatbotAnswer
                                        }
                                    </div>
                                </div>
                            </div> */}
                            <div className="flex justify-center gap-5 mb-5">
                                <button
                                    className="bg-white py-2 px-4 rounded-lg text-black"
                                    onClick={startListening}
                                >
                                    {
                                        listening ? 'Listening' : 'Start a Microphone'
                                    }
                                </button>
                                <button
                                    className="bg-white py-2 px-4 rounded-lg text-red-600"
                                    onClick={() => {
                                        SpeechRecognition.stopListening()
                                        handleUserQuery()
                                    }
                                    }
                                >Stop</button>
                                <button
                                    className="bg-white py-2 px-4 rounded-lg text-red-600"
                                    onClick={resetTranscript}
                                >Cancel</button>
                            </div>
                        </div>
                    </main>
                </div>
            </div>
        </div>
    )
}

export default ChatPage;