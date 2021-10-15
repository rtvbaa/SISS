import "./App.css";
import Header from './Header.js';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import ProductPage from "./ProductPage";
import DiscountPage from "./DiscountPage"
import SalePage from "./SalePage";
import StatisticsPage from "./StatisticsPage";

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
                        <SalePage/>
                    </Route>
                    <Route path="/Discount">
                        <DiscountPage/>
                    </Route>
                    <Route path="/Statistics">
                        <StatisticsPage/>
                    </Route>
                </Switch>
            </Router>
        </div>
    );
}

export default App;
