import { Button, Item } from '@vaadin/react-components'
import React from 'react'
import { useMediaQuery } from 'react-responsive'

interface Item {
  title: string;           
  units: string;   
  value: number;  
  id: number;
}

interface ButtonGroupProps {
  items: Item[];
  label: string;
  onValueChange: (value: number , index:number) => void;
  defaultSelectedId?: any;

}

const ButtonGroup = ({ items, label, onValueChange  ,defaultSelectedId }: ButtonGroupProps) => {
  const [allData, setAllData] = React.useState<any>();
  const [selected, setSelected] = React.useState<number>(defaultSelectedId ?? items[0].id);

  const isSmallScreen = useMediaQuery({
    query: '(max-width: 800px)',
  });

  React.useEffect(( ) => {
    const collectedData = items.map(item => ({
      title: item.title,
      value: item.value,
    }));
    setAllData(collectedData);
  }, [items]);


    const handleClick = (id: number, value: number) => {
      setSelected(id );
      onValueChange(value, id);
    };


    return (
      <div className="relative bg-red-">
        <div className="">
          <p className="text-primary-color font-semibold text-[16px] sm:text-[18px]">{label}</p>
          <div className="p-[5px]  rounded-[12px]  border-white  bg-white   shadow-xl ">
            <div className="relative flex  gap-[10px] md:gap-[30px] w-full overflow-hidden bg-red- p-[10px] h-[40px] md:h-[50px] items-center justify-center">
              {/* Slider */}
              <div
                className="highlight absolute left-0 h-full bg-gradient-to-r from-primary-color-150pct to-primary-color transition-transform duration-300 rounded-[8px]  shadow-inner  z-10 "
                style={{
                  width: `${100 / items.length}%`,
                  transform: `translateX(${items.findIndex(item => item.id === selected) * 100}%)`,
          
                }}
              >
              </div>

              {items.map((t) => {
                const title = t.title.split(/(?=\bBarthel\b)/)
                const shortTitle = t.title.split(' ').slice(-2).join(' ');
                return(
                <div
                  key={t.id}
                  // values={t.value}
                  onClick={() => handleClick(t.id, t.value)}
                  className={`flex-1 relative   cursor-pointer bg-red-  h-[30px] md:h-[50px] flex justify-center items-center rounded-[8px] ${
                    selected === t.id ? 'text-white z-20' : 'text-gray-700'
                  }`}
                  style={{
                    backgroundColor: t.id ? `transparent` : '#',
                  }}
                >
                  <div className="flex justify-center ">
                    <span className={` prevent-select text-[14px] sm:text-[18px] flex flex-col items-center`} >
                    {title.map((i, index) => (
                      <div key={index}>{isSmallScreen ? i.split(' ').slice(-1).join(' '):i}</div>
                    ))}
                      </span>

                    <span
                      className={`prevent-select ml-[5px] mt-[10px] text-[10px] sm:text-[12px] text-w-200 ${
                        selected === t.id ? 'text-white z-20' : 'text-gray-600'
                      }`}
                    >
                      {t.units}
                    </span>
                  </div>
                </div>
              )})}
            </div>
          </div>
        </div>
      </div>
    );
  };

export default ButtonGroup;





// React.useEffect(() => {
//   // console.log(`item: ${label}  current index: ${selected}  value: ${items[selected].value}`);
  
// }, [label, items, selected]);

