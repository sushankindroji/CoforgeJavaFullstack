import { Routes, Route } from 'react-router-dom'
import './App.css'
import Header from './components/Header'
import NavBar from './components/NavBar'
import Footer from './components/Footer'
import Home from './components/Home'
import AboutUs from './components/AboutUs'
import Addition from './components/Addition'
import CustomerForm from './components/CustomerForm'
import DisplayCustomers from './components/DisplayCustomers'
import HooksDemo from './components/HooksDemo'
import JSXDemo from './components/JSXDemo'
import JSXDemo1 from './components/JSXDemo1'
import JSXDemo2 from './components/JSXDemo2'
import Login from './components/Login'
import Login1 from './components/Login1'
import PropsDemo from './components/PropsDemo'
import Shopping from './components/Shopping'
import StudentManager from './components/StudentManager'
import SurveyResult from './components/SurveyResult'
import Welcome from './components/Welcome'
import UserProfile from './components/UserProfile'

function App() {
  return (
    <div className="app">
      <Header />
      <NavBar />

      <main className="page-content">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<AboutUs />} />
          <Route path="/addition" element={<Addition />} />
          <Route path="/customer-form" element={<CustomerForm />} />
          <Route path="/display-customers" element={<DisplayCustomers />} />
          <Route path="/hooks-demo" element={<HooksDemo />} />
          <Route path="/jsx-demo" element={<JSXDemo />} />
          <Route path="/jsx-demo1" element={<JSXDemo1 />} />
          <Route path="/jsx-demo2" element={<JSXDemo2 />} />
          <Route path="/welcome" element={<Welcome />} />
          <Route path="/user-profile" element={<UserProfile />} />
          <Route path="/login" element={<Login />} />
          <Route path="/login-1" element={<Login1 />} />
          <Route path="/props-demo" element={<PropsDemo />} />
          <Route path="/shopping" element={<Shopping />} />
          <Route path="/student-manager" element={<StudentManager />} />
          <Route path="/survey-result" element={<SurveyResult />} />
          <Route path="*" element={<Home />} />
        </Routes>
      </main>

      <Footer />
    </div>
  )
}

export default App
