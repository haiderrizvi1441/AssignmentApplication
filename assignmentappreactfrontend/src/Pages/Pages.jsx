import React from 'react'
import {Route, Routes} from 'react-router-dom'
import LoginUser from './LoginUser'
import RegisterUser from './RegisterUser'
import HomePage from './HomePage'

function Pages() {
  return (
    <Routes>
        
        <Route path="/" element={<HomePage/>} />
        <Route path='/login' element={<LoginUser/>}/>
        <Route path='/register' element={<RegisterUser/>}/>


    </Routes>
  )
}

export default Pages