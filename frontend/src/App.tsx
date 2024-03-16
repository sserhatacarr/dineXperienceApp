import { BrowserRouter, Route, Switch, Redirect } from "react-router-dom";
import { useContext } from "react";
import { AuthProvider, AuthContext } from "./context/AuthContext";
import { DataProvider } from "./context/DataContext";
import Auth from "./pages/Auth/Auth";
import Home from "./pages/Home/Home";
import Profile from "./pages/Profile/Profile";
import "./App.css";

function App() {
  const authContext = useContext(AuthContext);

  const jwt = authContext ? authContext.jwt : "";

  return (
    <div className="w-full h-[100%]">
      <BrowserRouter>
        <Switch>
          <AuthProvider>
            <DataProvider>
              <Route
                exact
                path="/"
                render={() =>
                  jwt === "" || jwt !== null ? <Redirect to="home" /> : <Auth />
                }
              />
              <Route
                exact
                path="/home"
                render={() =>
                  jwt !== "" || jwt !== null ? <Home /> : <Redirect to="/" />
                }
              />
              <Route
                exact
                path="/profile"
                render={() =>
                  jwt !== "" || jwt !== null ? <Profile /> : <Redirect to="/" />
                }
              />
            </DataProvider>
          </AuthProvider>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;

// queries
// modals
// Auth Redirect düzelt
// homedaki restaurantı komponente taşı
