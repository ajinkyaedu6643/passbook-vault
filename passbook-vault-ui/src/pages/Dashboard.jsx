import { Link } from "react-router-dom";

function Dashboard() {
    const logout = () => {

        localStorage.removeItem(
            "token"
        );

        window.location.href = "/";
    };

    return (

        <div className="container mt-5">

            <h1>
                Passbook Vault Dashboard
            </h1>

            <hr />

            <div className="alert alert-success">

                Login Successful

            </div>

            <div className="mt-3">

                <Link
                    to="/accounts"
                    className="btn btn-primary">

                    Manage Accounts

                </Link>

            </div>

            <button
                className="btn btn-danger"
                onClick={logout}>

                Logout

            </button>

        </div>
    );
}

export default Dashboard;