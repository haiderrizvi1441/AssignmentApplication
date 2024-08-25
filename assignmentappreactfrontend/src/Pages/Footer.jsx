
import React from 'react'

function Footer() {
    return (
        <div>
            {/* FOOTER SECTION  */}

            <div className='w-full bg-gray-600 px-4 text-white '>

                <div className='w-full bg-gray-600 px-4 text-white pt-10 pb-6 flex flex-row flex-wrap justify-between'>
                    <p className='text-sm text-white font-bold p-1 hover:text-lime-500'>About us</p>
                    <p className='text-sm text-white font-bold p-1 hover:text-lime-500'>Careers</p>
                    <p className='text-sm text-white font-bold p-1 hover:text-lime-500'>Legal Certificates</p>
                    <p className='text-sm text-white font-bold p-1 hover:text-lime-500'>Support Us</p>
                    <p className='text-sm text-white font-bold p-1 hover:text-lime-500'>Contact Us</p>
                </div>

                <p className='font-bold'>
                    © Haider Rizvi 2023
                </p>
            </div>
        </div>
    )
}

export default Footer