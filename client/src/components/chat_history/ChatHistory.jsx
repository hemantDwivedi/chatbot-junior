import Header from "../user_profile/UserProfile";

const ChatHistory = () => {
    return (
        <div className="bg-neutral-950 text-gray-600 h-full overflow-auto text-left">
            <div className="sticky top-0 bg-neutral-950 px-2 py-3 flex gap-2 justify-center">
                <img width="34" height="34" src="https://img.icons8.com/nolan/64/artificial-intelligence.png" alt="artificial-intelligence" />
                <p className="text-gray-600 font-bold uppercase my-auto">
                    Chatbot Junior
                </p>
            </div>
            <div className="min-h-full p-2">
                <div className="py-3 border-b border-violet-950 px-2">Chat history 1</div>
                <div className="py-3 border-b border-violet-950 px-2">Chat history 2</div>
                <div className="py-3 border-b border-violet-950 px-2">Chat history 3</div>
            </div>
            <div className="border-t sticky border-violet-950 px-2 py-3 bottom-0">
                <Header />
            </div>
        </div>
    );
}

export default ChatHistory;