import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../services/authService";

function Login() {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    const handleLogin = async (e) => {

        e.preventDefault();

        try {

            const result =
                await login(
                    username,
                    password
                );

            localStorage.setItem(
                "token",
                result.token
            );

            navigate("/dashboard");

        } catch (error) {

            alert(
                "Invalid username or password"
            );
        }
    };

    return (

        <div className="container">

            <div className="row justify-content-center mt-5">

                <div className="col-md-4">

                    <div className="card shadow">

                        <div className="card-body">

                            <h3 className="text-center mb-4">
                                Passbook Vault
                            </h3>

                            <form onSubmit={handleLogin}>

                                <div className="mb-3">

                                    <label>
                                        Username
                                    </label>

                                    <input
                                        type="text"
                                        className="form-control"
                                        value={username}
                                        onChange={(e) =>
                                            setUsername(
                                                e.target.value)}
                                    />

                                </div>

                                <div className="mb-3">

                                    <label>
                                        Password
                                    </label>

                                    <input
                                        type="password"
                                        className="form-control"
                                        value={password}
                                        onChange={(e) =>
                                            setPassword(
                                                e.target.value)}
                                    />

                                </div>

                                <button
                                    className="btn btn-primary w-100">

                                    Login

                                </button>

                            </form>

                        </div>

                    </div>

                </div>

            </div>

        </div>
    );
}

export default Login;