<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
    <title>Agama passkey</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${webCtx.contextPath}/servlet/favicon" type="image/x-icon">
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="${webCtx.contextPath}/auth/fido2/js/base64js.js"></script>
    <script src="${webCtx.contextPath}/auth/fido2/js/base64url.js"></script>
    <script src="${webCtx.contextPath}/auth/fido2/js/webauthn.js"></script>
    <script>
        tailwind.config = {
            darkMode: 'class'
        }
    </script>
</head>
<body>
<script>
    function registerPasskey() {
        const myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");
        const raw = JSON.stringify({
            attestation: "direct",
            displayName: "${userData.name}",
            username: "${userData.uid}",
            authenticatorSelection: {
                requireResidentKey: true,
                residentKey: "preferred",
                userVerification: "preferred"
            },
            excludeCredentials: [],
            timeout: 90000,
            extensions: {
                credProps: true
            }
        });
        const requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };
        fetch("/jans-fido2/restv1/attestation/options", requestOptions)
            .then(response => response.text())
            .then(result => {
                console.log('Result: ' + result);

            })
            .catch(error => console.log('error', error));

    }
</script>
<section class="bg-gray-100 dark:bg-gray-900">
    <div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
        <div class="flex flex-col items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
            <img class="w-40 mr-2"
                 src="https://gluu.org/wp-content/uploads/2021/02/janssen-project-transparent-630px-182px-300x86.png"
                 alt="logo">
        </div>
        <div class="w-full bg-white rounded-lg shadow-lg dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
            <form method="post" enctype="application/x-www-form-urlencoded"
                  class="p-6 space-y-4 md:space-y-6 sm:p-8">
                <div class="flex items-center justify-center">
                    <svg aria-hidden="true" height="24" viewBox="0 0 24 24" version="1.1" width="24"
                         data-view-component="true" class="w-8 h-8">
                        <path d="M9.496 2a5.25 5.25 0 0 0-2.519 9.857A9.006 9.006 0 0 0 .5 20.228a.751.751 0 0 0 .728.772h5.257c3.338.001 6.677.002 10.015 0a.5.5 0 0 0 .5-.5v-4.669a.95.95 0 0 0-.171-.551 9.02 9.02 0 0 0-4.814-3.423A5.25 5.25 0 0 0 9.496 2Z"></path>
                        <path d="M23.625 10.313c0 1.31-.672 2.464-1.691 3.134a.398.398 0 0 0-.184.33v.886a.372.372 0 0 1-.11.265l-.534.534a.188.188 0 0 0 0 .265l.534.534c.071.07.11.166.11.265v.347a.374.374 0 0 1-.11.265l-.534.534a.188.188 0 0 0 0 .265l.534.534a.37.37 0 0 1 .11.265v.431a.379.379 0 0 1-.097.253l-1.2 1.319a.781.781 0 0 1-1.156 0l-1.2-1.319a.379.379 0 0 1-.097-.253v-5.39a.398.398 0 0 0-.184-.33 3.75 3.75 0 1 1 5.809-3.134ZM21 9.75a1.125 1.125 0 1 0-2.25 0 1.125 1.125 0 0 0 2.25 0Z"></path>
                    </svg>
                </div>

                <h1 class="text-xl text-center font-medium text-gray-900 md:text-2xl dark:text-white">
                    Add a passkey
                </h1>

                <p class="text-gray-600 leading-tight">
                    Passkeys can be used for sign-in as a simple and secure alternative to your password and
                    two-factor credentials.
                </p>

                <div class="space-y-2">
                    <button type="button"
                            onclick="registerPasskey()"
                            class="w-full text-white bg-green-600 hover:bg-green-700 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
                        Add passkey
                    </button>

                    <button type="submit"
                            name="cancelBtn"
                            class="w-full text-black bg-gray-50 border border-gray-300 hover:bg-gray-100 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">
                        Cancel
                    </button>
                </div>
            </form>
        </div>
    </div>
</section>
</body>
</html>
