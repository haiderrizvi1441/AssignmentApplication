import React from 'react'
import village from '../Resources/Images/lc-village.jpg'
import village2 from '../Resources/Images/lc-village2.jpg'
import village1 from '../Resources/Images/ref.png'
import lawconnectback from '../Resources/Images/lawconnectbackground.jpg'
import briefcase from '../Resources/Icons/briefcaseIcon.svg'
import pen from '../Resources/Icons/penIcon.svg'
import services from '../Resources/Icons/servicesIcon.svg'
import duedill from '../Resources/Icons/dueDilligence.svg'
import advocacy from '../Resources/Icons/caseAdvocacyIcon.svg'
import drafting from '../Resources/Icons/draftingIcon.svg'
import advice from '../Resources/Icons/legalAdviceIcon.svg'
function Hero() {
    return (
        <div>
            <div className='Hero w-full '>
                {/* Image Section  */}
                <div className='relative w-full'>
                    <img src={lawconnectback} alt="village" className='w-full h-1/2 object-cover' />

                    <div className='absolute top-0 left-0 w-full h-full flex items-center justify-center bg-black bg-opacity-50 text-white'>
                        <h1 className='text-4xl font-semibold italic'>Providing Legal Services Across India </h1>
                    </div>
                </div>

                {/*     QUOTE SECTION */}
                <div className='lawyersection h-auto w-100 flex flex-wrap flex-col items-center text-center p-10 bg-slate-900'>

                    {/* Hero Text Material  */}
                    <div className='w-full h-auto flex flex-wrap flex-col items-center text-center p-10'>
                        <p className='text-yellow-300 font-bold text-2xl'>"Connecting Indian Legal System to Everyone!</p>
                        <div className='text-lime-500 font-bold text-4xl'>______</div>
                    </div>

                    {/* SERVICE SECTION */}
                    <div className='w-full flex flex-wrap justify-evenly'>
                        <div className='w-46 flex flex-col items-center mb-12'>
                            <img className='w-28 h-28' src={briefcase} alt="Briefcase icon" />
                            <p className='text-3xl font-bold text-white'>500+</p>
                            <p className='text-xl font-bold text-green-100'>Different Legal Vendors</p>
                        </div>
                        <div className='w-46 flex flex-col items-center mb-12'>
                            <img className='w-28 h-28' src={pen} alt="Pen icon" />
                            <p className='text-3xl font-bold text-white'>Free !</p>
                            <p className='text-xl font-bold text-green-100'>First Case Drafting</p>
                        </div>
                        <div className='w-46 flex flex-col items-center mb-12'>
                            <img className='w-28 h-28' src={services} alt="Services icon" />
                            <p className='text-3xl font-bold text-white'>100+</p>
                            <p className='text-xl font-bold text-green-100'>Different Legal Services</p>
                        </div>
                    </div>

                    {/* PRODCUT SECTION  */}
                    <div className='w-full h-auto flex flex-wrap flex-col items-center text-center p-10'>
                        <p className='text-yellow-300 font-bold text-2xl'>"Our Products & Services"</p>
                        <div className='text-lime-300 font-bold text-4xl'>______</div>
                    </div>
                    {/* Product Cards  */}
                    <div className='w-full flex flex-wrap justify-evenly'>
                        <div className='w-46 flex flex-col items-center mb-12 border-white border-2 p-2 rounded-xl'>
                            <img className='w-20 h-20' src={duedill} alt="Due Dilligence" />
                            <p className='text-2xl font-bold text-white'>Due Dilligence</p>
                            <p className='text-sm font-bold text-lime-500'> Mergers and Aquisitions</p>
                        </div>
                        <div className='w-46 flex flex-col items-center mb-12 border-white border-2 p-2 rounded-xl'>
                            <img className='w-20 h-20' src={advocacy} alt="Case Advocacy" />
                            <p className='text-2xl font-bold text-white'>Case Advocacy</p>
                            <p className='text-sm font-bold text-lime-500'> Helps Wins Cases</p>
                        </div>
                        <div className='w-46 flex flex-col items-center mb-12 border-white border-2 p-2 rounded-xl'>
                            <img className='w-20 h-20' src={drafting} alt="Drafting" />
                            <p className='text-2xl font-bold text-white'>Drafting</p>
                            <p className='text-sm font-bold text-lime-500'> Drafting Support</p>
                        </div>
                        <div className='w-46 flex flex-col items-center mb-12 border-white border-2 p-2 rounded-xl'>
                            <img className='w-20 h-20' src={advice} alt="Legal Advice" />
                            <p className='text-2xl font-bold text-white'>Legal Advice</p>
                            <p className='text-sm font-bold text-lime-500'> Advisory Support</p>
                        </div>
                    </div>


                </div>

            </div>


        </div>
    )
}

export default Hero