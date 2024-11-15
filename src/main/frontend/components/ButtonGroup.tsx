import { Button } from '@vaadin/react-components'
import React from 'react'

interface Item {
  title?: string;
  active?: string;
  value?: number;
  placeholder?:string;
}

interface Items {
  items: Item[];
  label: string;
  onValueChange: (value: number) => void;
}

const ButtonGroup = ({ items, label, onValueChange }: Items) => {
  const [selected, setSelected] = React.useState<number>(0);

  const handleClick = (index: number) => {
    setSelected(index);
  };

  React.useEffect(() => {
    // Send the value of the selected item to the parent component
    if (items[selected].value !== undefined) {
      onValueChange(items[selected].value)
    }
  }, [selected, items, onValueChange]);

  return (
    <div className="relative bg-red-" >
      <div className='mx-[] '>
        <p className='text-primary-color font-semibold text-[16px]'>{label}</p>
        <div className="p-[5px] bg-white rounded-[12px] border-[2px] border-green- bg-red-">
          <div className="relative flex gap-1 w-full overflow-hidden bg-red-   p-[10px] h-[40px] items-center justify-center">
            {/* Slider */}
            <div
              className="absolute left-0 h-full bg-primary-color transition-transform duration-300 rounded-[12px] z-10"
              style={{
                width: `${100 / items.length}%`,
                transform: `translateX(${selected * 100}%)`,
              }}
            >
            </div>
            {items.map((t, i) => (
              <div
                key={i}
                onClick={() => handleClick(i)}
                className={`flex-1 relative  px-[10px]  text-center cursor-pointer bg-red- h-[40px] flex justify-center items-center ${
                  selected === i ? 'text-white z-20' : 'text-gray-700'
                }`}
                style={{
                  backgroundColor: selected === i ? 'transparent' : undefined,
                }}
              >
                <div className='flex justify-center '>
                <span className='text-[18px] font-semibold '>{t.title} </span>
                <span className={`ml-[5px] mt-[10px] text-[14px] text-w-200  ${ selected === i ? 'text-white z-20' : 'text-gray-600'}`} >
                    {t.placeholder}
                </span>
                </div>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ButtonGroup;