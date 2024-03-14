import { useState } from "react";
import ChatHistory from "../chat_history/ChatHistory";

const ChatPage = () => {

    const [userQuery, setUserQuery] = useState('')
    const [query, setQuery] = useState('')
    const [chatbotAnswer, setChatbotAnswer] = useState('')

    function handleUserQuery() {
        setQuery(userQuery)
    }

    function onEnterKey(e){
        if (e.key === "Enter"){
            handleUserQuery()
        }
    }

    return (
        <div>
            <div className="flex h-screen bg-neutral-950 text-violet-800">
                <div className="w-1/5">
                    <ChatHistory />
                </div>
                <div className="flex-1 flex flex-col">
                    <header className="text-gray-600 py-4 px-6 flex justify-end">
                        <button className="text-sm p-2.5 border border-gray-500 rounded-lg hover:bg-gray-800">
                            Sign out
                        </button>
                    </header>
                    <main className="flex-1 p-4">
                        <div className="flex flex-col h-full max-w-3xl mx-auto">
                            <div className="overflow-y-auto flex-1">
                                {
                                    query.length != 0 &&
                                    <div className="flex gap-3 mb-2">
                                        <img className="w-8 h-8 my-auto" src="https://img.icons8.com/nolan/64/user.png" alt="user" />
                                        <div className="py-2 max-w-2xl">
                                            {query}
                                        </div>
                                    </div>
                                }
                                {
                                    chatbotAnswer.length != 0 &&
                                    <div className="flex mb-2 gap-3">
                                        <img
                                            src="https://img.icons8.com/nolan/64/artificial-intelligence.png"
                                            alt="artificial-intelligence"
                                            className="w-8 h-8 my-auto"
                                        />
                                        <div className="py-2 max-w-2xl">
                                            {chatbotAnswer}
                                        </div>
                                    </div>
                                }
                            </div>
                            <div className="flex items-center border border-gray-600 rounded-xl p-2">
                                <input
                                    type="text"
                                    placeholder="Message Chatbot"
                                    className="flex-1 p-2 outline-none bg-transparent placeholder:text-gray-600"
                                    value={userQuery}
                                    onChange={(e) => setUserQuery(e.target.value)}
                                    onKeyDown={(e) => onEnterKey(e)}
                                />
                                <button
                                    className="ml-2 bg-zinc-800 hover:bg-gray-600 hover:text-gray-900 text-gray-600 rounded-full p-2 transition duration-300"
                                    onClick={() => handleUserQuery()}
                                >
                                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-6 h-6">
                                        <path fillRule="evenodd" d="M11.47 2.47a.75.75 0 0 1 1.06 0l7.5 7.5a.75.75 0 1 1-1.06 1.06l-6.22-6.22V21a.75.75 0 0 1-1.5 0V4.81l-6.22 6.22a.75.75 0 1 1-1.06-1.06l7.5-7.5Z" clipRule="evenodd" />
                                    </svg>
                                </button>
                            </div>
                        </div>
                    </main>
                </div>
            </div>
        </div>
    )
}

export default ChatPage;