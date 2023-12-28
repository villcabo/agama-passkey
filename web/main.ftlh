<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <title>Agama passkey</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${webCtx.contextPath}/servlet/favicon" type="image/x-icon">
    <script src="https://cdn.tailwindcss.com"></script>
    <script>
        tailwind.config = {
            darkMode: 'class'
        }
    </script>
</head>
<body>
<section class="bg-gray-100 dark:bg-gray-900">
    <div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
        <div class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
            <img class="w-40 mr-2"
                 src="https://gluu.org/wp-content/uploads/2021/02/janssen-project-transparent-630px-182px-300x86.png"
                 alt="logo">
        </div>
        <div class="w-full bg-white rounded-lg shadow-lg dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
            <form method="post" enctype="application/x-www-form-urlencoded" class="p-6 space-y-4 md:space-y-6 sm:p-8">
                <h1 class="text-xl text-center font-medium text-gray-900 md:text-2xl dark:text-white">
                    Agama Passkey
                </h1>

                <div class="space-y-3">
                    <div>
                        <label for="username" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
                            Username
                        </label>
                        <input type="text" name="username" id="username"
                               class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                               placeholder="" required="" autocomplete="off">
                    </div>
                    <div>
                        <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
                            Password
                        </label>
                        <input type="password" name="password" id="password" placeholder=""
                               class="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                               required="">
                    </div>
                </div>

                <button type="submit"
                        name="loginBtn"
                        class="w-full text-white bg-green-600 hover:bg-green-700 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
                    Sign in
                </button>

                <div class="relative">
                    <div class="absolute inset-0 flex items-center">
                        <div class="w-full border-t border-gray-300"></div>
                    </div>
                    <div class="relative flex justify-center text-sm">
                        <span class="px-2 bg-white text-gray-900">
                            Or
                        </span>
                    </div>
                </div>

                <button type="submit" name="loginWithPasskeyBtn" formnovalidate
                        class="w-full text-black bg-gray-50 border border-gray-300 hover:bg-gray-100 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
                    Sign in with a passkey
                </button>
            </form>
        </div>
    </div>
</section>
</body>
</html>
