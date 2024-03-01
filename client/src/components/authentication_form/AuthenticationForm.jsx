const AuthenticationForm = ({ authenticationName }) => {
    return (
        <div>
            <div className="container-lg">
                <div className="flex min-h-screen justify-center items-center">
                    <div className="max-w-sm bg-gray-800 rounded-lg p-5 w-full">
                        <div className="mt-4">
                            <div className="flex justify-center">
                                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-10 h-10">
                                    <path fillRule="evenodd" d="M18.685 19.097A9.723 9.723 0 0 0 21.75 12c0-5.385-4.365-9.75-9.75-9.75S2.25 6.615 2.25 12a9.723 9.723 0 0 0 3.065 7.097A9.716 9.716 0 0 0 12 21.75a9.716 9.716 0 0 0 6.685-2.653Zm-12.54-1.285A7.486 7.486 0 0 1 12 15a7.486 7.486 0 0 1 5.855 2.812A8.224 8.224 0 0 1 12 20.25a8.224 8.224 0 0 1-5.855-2.438ZM15.75 9a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0Z" clipRule="evenodd" />
                                </svg>
                            </div>
                            <h2 className="mt-2 text-center text-3xl font-extrabold">
                                {
                                    authenticationName == 0 ? "Sign in" : "Sign up"
                                }
                            </h2>
                            <p className="text-center text-sm text-gray-500 mt-5 mb-5">
                                Don't have an account yet? {' '}
                                <button className="text-green-400 font-bold">{
                                    authenticationName != 0 ? "Sign in" : "Sign up"
                                }</button>
                            </p>
                        </div>
                        <div className="mb-2">
                            <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-500">Email</label>
                            <input type="email" placeholder="your@gmail.com"
                                className="bg-gray-900 text-sm font-medium w-full p-2.5 rounded-lg focus:border-green-400 block dark:bg-gray-900 dark:border-gray-900 dark:placeholder-gray-600 dark:text-white dark:focus:ring-green-400 dark:focus:border-green-400"
                            />
                        </div>
                        <div className={authenticationName == 0 ? "mb-5" : "mb-2"}>
                            <label className="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-500">Password</label>
                            <input type="password"
                                className="bg-gray-900 text-sm font-medium w-full p-2.5 rounded-lg focus:border-green-400 block dark:bg-gray-900 dark:border-gray-900 dark:placeholder-gray-600 dark:text-white dark:focus:ring-green-400 dark:focus:border-green-400"
                            />
                        </div>
                        {
                            authenticationName == 1 &&
                            <div className="inline-flex items-center mb-5">
                                <label className="relative -ml-2.5 flex cursor-pointer items-center rounded-full p-3">
                                    <input type="checkbox"
                                        className="before:content[''] peer relative h-5 w-5 cursor-pointer appearance-none rounded-md border border-blue-gray-200 transition-all before:absolute before:top-2/4 before:left-2/4 before:block before:h-12 before:w-12 before:-translate-y-2/4 before:-translate-x-2/4 before:rounded-full before:bg-blue-gray-500 before:opacity-0 before:transition-opacity checked:border-gray-900 checked:bg-gray-900 checked:before:bg-gray-900 hover:before:opacity-10"
                                        id="remember" />
                                    <span
                                        className="absolute text-green-400 transition-opacity opacity-0 pointer-events-none top-2/4 left-2/4 -translate-y-2/4 -translate-x-2/4 peer-checked:opacity-100">
                                        <svg xmlns="http://www.w3.org/2000/svg" className="h-3.5 w-3.5" viewBox="0 0 20 20" fill="currentColor"
                                            stroke="currentColor" strokeWidth="1">
                                            <path fillRule="evenodd"
                                                d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z"
                                                clipRule="evenodd"></path>
                                        </svg>
                                    </span>
                                </label>
                                <label className="mt-px font-light text-gray-500 cursor-pointer select-none">
                                    <p className="flex items-center text-sm antialiased font-normal leading-normal text-gray-500">
                                        suggest password?
                                    </p>
                                </label>
                            </div>
                        }
                        <button
                            className="w-full text-sm font-medium text-green-400 bg-gray-900 p-2 rounded hover:bg-gray-700 focus:ring-4 focus:outline-none"
                        >
                            {
                                authenticationName == 0 ? "Sign in" : "Sign up"
                            }
                        </button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default AuthenticationForm;