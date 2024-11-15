import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import ButtonGroup from 'Frontend/components/ButtonGroup';
import Footer from 'Frontend/components/Footer';
import Heading from 'Frontend/components/Heading';
import React, { useState } from 'react';
// import { fetchDataFn } from 'Frontend/utils/constants/get-data';
import ResultContainer from 'Frontend/components/ResultContainer';
import { DataServiceEndpoint } from 'Frontend/generated/endpoints';
import TableInterface from 'Frontend/generated/com/example/application/utils/TableInterface';
import { fetchDataFn } from 'Frontend/utils/constants/get-data';




export default function EmptyView() {
  const [ageValue, setAgeValue] = useState<number>(0);
  const [sexValue, setSexValue] = useState<number>(0);
  const [barthelIndexValue, setBarthelIndexValue] = useState<number>(0);
  const [bnpValue, setBnpValue] = useState<number>(0);
  const [sodiumValue, setSodiumValue] = useState<number>(0);
  const [aceArbValue, setAceArbValue] = useState<number>(0);
  const [historyOfHfValue, setHistoryOfHfValue] = useState<number>(0);
  const [sbpValue, setSbpValue] = useState<number>(0);
  const [hemoglobinValue, setHemoglobinValue] = useState<number>(0);
  const [albuminValue, setAlbuminValue] = useState<number>(0);
  const [bunValue, setBunValue] = useState<number>(0);
  const [data, setData] = useState<{ [source: string]: TableInterface[] }>({});
  // const [data, setData] = useState< any>();

  React.useEffect(() => {
    const fetchData = async () => {
    const res = await fetchDataFn();
    const dat2 = await  DataServiceEndpoint.getAllData()
    // console.log(dat2 , 'yawa')
    setData(res);

  }
    fetchData();
    console.log(data , 'test');
  }, []);


  const totalValue =
        ageValue +
        sexValue +
        barthelIndexValue +
        bnpValue +
        sodiumValue +
        aceArbValue +
        historyOfHfValue +
        sbpValue +
        hemoglobinValue +
        albuminValue +
        bunValue;

  const oneYearMortality = (1 - 0.77921 * Math.exp(totalValue - 1.37464)) * 100;
  const threeYearMortality = (1 - 0.51646 * Math.exp(totalValue - 1.37464)) * 100;

  return (
    <div>
      <Heading/>
        <div className='w-full  bg bg-red- flex items-center justify-center'>
          <div className='container w-[100%] sm:w-[80%] md:w-[90%] lg:w-[70%]  bg-primary-color-50pct flex justify-center'>
            <div className=' w-full flex flex-col items-center'>
              <div className='w-full  pl-[5px] pt-[15px] text-primary-color text-[14px] font-semibold  sm:text-[18px]'>
                Estimation of 1-year and 3-years mortality in heart failure patiants aged 80 years and older
              </div>
              <div className='container-1 w-[90%] mx-[20px] sm:w-[90%] md:w-[80%]   mt-[30px] flex flex-col gap-[20px]'>
                {data.age && (
                  <ButtonGroup
                    label="Age"
                    items={[
                      { title: data.age[0].label, value: data.age[0].value ,placeholder:'years' },
                      { title: data.age[1].label, value: data.age[1].value ,placeholder:'years'  },
                      { title: data.age[2].label, value: data.age[2].value ,placeholder:'years'  },

                    ]}
                    onValueChange={setAgeValue}
                  />
                )}
                {data.gender && (
                  <ButtonGroup
                    label="Gender"
                    items={[
                      { title: data.gender[0].label, value: data.gender[0].value },
                      { title: data.gender[1].label, value: data.gender[1].value },
                    ]}
                    onValueChange={setSexValue}
                  />
                )}
                {/* {
                  data.map(((e ,i) ) => (
                    <ButtonGroup
                    label={e.title}
                    items={i.data}
                    onValueChange={setSexValue}
                  />  
                  )) 

                } */}
              <ButtonGroup
                label="Barthel index"
                items={[
                  { title: `≥90`, value: 0 , },
                  { title: '61-90', value: 0.34902 },
                  { title: '<60', value: 0.78954 },
                ]}
                onValueChange={setBarthelIndexValue}
              />
              <ButtonGroup
                label="History of HF"
                items={[
                  { title: 'No', value: 0 },
                  { title: 'Yes', value: 0.35664 },
                ]}
                onValueChange={setHistoryOfHfValue}
              />
                <ButtonGroup
                  label="SBP"
                  items={[
                    { title: '≥100', value: 0 , placeholder:'mmHg' },
                    { title: '≤100', value: 0.31585 , placeholder:'mmHg'},
                  ]}
                  onValueChange={setSbpValue}
              />
              <ButtonGroup
                label="Hemoglobin"
                items={[
                  { title: '≥12', value: 0 , placeholder:'g/dL' },
                  { title: '10-11.9', value: 0.23813 , placeholder:'g/dL' },
                  { title: '<10', value: 0.40091 , placeholder:'g/dL' },
                ]}
                onValueChange={setHemoglobinValue}
              />
              <ButtonGroup
                label="Albumin"
                items={[
                  { title: '≥3', value: 0 , placeholder:'g/dL' },
                  { title: '<3', value: 0.37812  , placeholder:'g/dL'},
                ]}
                onValueChange={setAlbuminValue}
              />
              <ButtonGroup
                label="BUN"
                items={[
                  { title: '<25', value: 0 , placeholder:'mg/dL' },
                  { title: '≥25', value: 0.21341  , placeholder:'mg/dL'},
                ]}
                onValueChange={setBunValue}
              />
              <ButtonGroup
              label="BNP"
              items={[
                { title: '<300', value: 0, placeholder:'pg/dL' },
                { title: '≥300', value: 0.29743 , placeholder:'pg/dL' },
              ]}
              onValueChange={setBnpValue}
              />
              <ButtonGroup
                label="Sodium"
                items={[
                  { title: '≥130', value: 0  , placeholder:'mEq/L'},
                  { title: '<130', value: 0.60705 , placeholder:'mEq/L'},
                ]}
                onValueChange={setSodiumValue}
              />
              <ButtonGroup
                label="ACE/ARB use"
                items={[
                  { title: 'No', value: 0.20517 },
                  { title: 'Yes', value: 0 },
                ]}
                onValueChange={setAceArbValue}
              />
              <div className='mb-[50px]'> 
                <ResultContainer total={totalValue} oneyear={oneYearMortality} threeyear={threeYearMortality} />
              </div>
              </div>
            </div>
          </div>
        </div>
        <Footer/>
    </div>
  );
}
