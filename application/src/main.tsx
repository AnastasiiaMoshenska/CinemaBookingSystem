import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import './index.css'
import {BrowserRouter, Route, Routes} from "react-router-dom";
import BookingPage from "./components/BookingPage/BookingPage";
import ConfirmationPage from "./components/ConfirmationPage/ConfirmationPage";

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
      <BrowserRouter>
          <Routes>
              <Route path="/" element={<App />}></Route>
              <Route path="/booking" element={<BookingPage />}></Route>
              <Route path="/confirmation" element={<ConfirmationPage />}></Route>
          </Routes>
      </BrowserRouter>
  </React.StrictMode>
)
