import "./App.css";
import Header from './Header.js';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import ProductPage from "./ProductPage";

function App() {
    return (
        <div className="App">
            <Router>
                <header className="App-header"><Header/></header>
                <Switch>
                    <Route exact path="/">
                        <ProductPage/>
                    </Route>
                    <Route path="/Sale">
                        <body className="App-body">
                        <p>Sale</p>
                        </body>
                    </Route>
                    <Route path="/Discount">
                        <body className="App-body">
                        <p>Discount</p>
                        </body>
                    </Route>
                </Switch>
            </Router>
        </div>
    );
}

export default App;
