import ChatHistory from "../chat_history/ChatHistory";

const ChatPage = () => {
    return (
        <div>
            <div className="flex h-screen bg-zinc-900 text-white">
                <ChatHistory />
                <div className="flex-1 flex flex-col">
                    <header className="text-gray-600 py-4 px-6 flex items-center justify-between">
                        <h1 className="text-xl font-semibold">Chatbot Junior</h1>
                        <button className="text-sm p-2.5 border border-gray-500 rounded-lg hover:bg-gray-800">
                            Sign out
                        </button>
                    </header>
                    <main className="flex-1 p-4">
                        <div className="flex flex-col h-full max-w-3xl mx-auto">
                            <div className="overflow-y-auto flex-1">
                                <div className="flex flex-col mb-2">
                                    <span className="text-lg text-gray-500">You</span>
                                    <div className="py-2 max-w-2xl">
                                        I need help with a programming problem.
                                    </div>
                                </div>
                                <div className="flex flex-col mb-2">
                                    <span className="text-lg text-gray-500">Chatbot</span>
                                    <div className="py-2 max-w-2xl">
                                        Of course! Feel free to describe the programming problem you're facing, and I'll do my best to assist you.
                                    </div>
                                </div>
                            </div>
                            <div className="flex items-center border border-gray-600 rounded-xl p-2">
                                <input
                                    type="text"
                                    placeholder="Message Chatbot"
                                    className="flex-1 p-2 outline-none bg-transparent placeholder:text-gray-600"
                                // value={value}
                                // onChange={onChange}
                                />
                                <button
                                    className="ml-2 bg-zinc-800 hover:bg-gray-600 hover:text-gray-900 text-gray-600 rounded-full p-2 transition duration-300"
                                // onClick={onSend}
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