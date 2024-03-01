import Header from "../user_profile/UserProfile";

const ChatHistory = () => {
    return (
        <div className="bg-neutral-950 text-white h-full w-1/6 overflow-y-auto py-5 px-2 text-left">
            {/* Chat history items */}
            <div className="py-2">Chat history 1</div>
            <div className="py-2">Chat history 2</div>
            <div className="py-2">Chat history 3</div>
            <div className="sticky bottom-0 mt-4">
                <Header />
            </div>
            {/* More chat history items */}
        </div>
    );
}

export default ChatHistory;