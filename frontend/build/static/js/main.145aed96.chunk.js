(this.webpackJsonpfrontend=this.webpackJsonpfrontend||[]).push([[0],{10:function(e,t,c){},12:function(e,t,c){"use strict";c.r(t);var n=c(1),r=c.n(n),d=c(3),i=c.n(d),o=(c(9),c(4)),s=(c(10),c(0));var j=function(e){return Object(s.jsxs)("table",{className:"table",children:[Object(s.jsx)("thead",{children:Object(s.jsxs)("tr",{children:[Object(s.jsx)("th",{children:"ID"}),Object(s.jsx)("th",{children:"Product name"}),Object(s.jsx)("th",{children:"Product price"})]})}),Object(s.jsx)("tbody",{id:"data",children:e.items.map((function(e){return Object(s.jsxs)("tr",{children:[Object(s.jsx)("td",{children:e.id}),Object(s.jsx)("td",{children:e.productName}),Object(s.jsx)("td",{children:e.productPrice})]})}))}),Object(s.jsxs)("tr",{children:[Object(s.jsx)("td",{children:"id"}),Object(s.jsxs)("td",{children:[Object(s.jsx)("label",{htmlFor:"NewProductName"}),Object(s.jsx)("input",{id:"NewProductName",type:"text",size:"40"})]}),Object(s.jsxs)("td",{children:[Object(s.jsx)("label",{htmlFor:"NewProductPrice"}),Object(s.jsx)("input",{id:"NewProductPrice",type:"number",size:"40"})]})]})]})},u=[{id:"1",productName:"name",productPrice:23}];var a=function(){var e=Object(n.useState)(u),t=Object(o.a)(e,2),c=t[0],r=t[1];return Object(n.useEffect)((function(){fetch("http://localhost:8080/get").then((function(e){return e.json()})).then((function(e){r(e)}))})),Object(s.jsx)("div",{className:"App",children:Object(s.jsxs)("header",{className:"App-header",children:[Object(s.jsx)("div",{className:"container",children:Object(s.jsx)(j,{items:c})}),Object(s.jsx)("div",{children:Object(s.jsx)("button",{id:"the-button",onClick:function(){console.log("POST"),function(){var e={productName:document.getElementById("NewProductName").value,productPrice:document.getElementById("NewProductPrice").value};fetch("http://localhost:8080/post",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(e)}).then((function(e){return e.json()})).then((function(){window.location.reload()}))}()},children:"Add a new product"})})]})})},l=function(e){e&&e instanceof Function&&c.e(3).then(c.bind(null,13)).then((function(t){var c=t.getCLS,n=t.getFID,r=t.getFCP,d=t.getLCP,i=t.getTTFB;c(e),n(e),r(e),d(e),i(e)}))};i.a.render(Object(s.jsx)(r.a.StrictMode,{children:Object(s.jsx)(a,{})}),document.getElementById("root")),l()},9:function(e,t,c){}},[[12,1,2]]]);
//# sourceMappingURL=main.145aed96.chunk.js.map