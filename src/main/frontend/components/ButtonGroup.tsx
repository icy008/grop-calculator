import { Button } from '@vaadin/react-components'
import React from 'react'

interface Item {
  title: string;
  active?: string;
  value?: number;
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
      onValueChange(items[selected].value);
    }
  }, [selected, items, onValueChange]);

  return (
    <div className="relative bg-red-">
      <div>
        <p className='text-primary-color'>{label}</p>
        <div className="p-[5px] bg-white rounded-[12px] h-[]">
          <div className="relative flex gap-1 w-[400px] overflow-hidden bg-red- p-[10px] h-[30px] items-center justify-center">
            {/* Slider */}
            <div
              className="absolute left-0 h-full bg-primary-color transition-transform duration-300 rounded-[12px] z-10"
              style={{
                width: `${100 / items.length}%`,
                transform: `translateX(${selected * 100}%)`,
              }}
            />
            {items.map((t, i) => (
              <div
                key={i}
                onClick={() => handleClick(i)}
                className={`flex-1 relative px-[20px] py-2 text-center cursor-pointer  ${
                  selected === i ? 'text-white z-20' : 'text-gray-700'
                }`}
                style={{
                  backgroundColor: selected === i ? 'transparent' : undefined,
                }}
              >
                {t.title}
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ButtonGroup;