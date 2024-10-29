import React, { useState } from 'react';

interface Tab {
  id: string;
  label: string;
}

interface TabsProps {
  tabs: Tab[];
  onTabClick?: (id: string) => void;
}

const Tabs: React.FC<TabsProps> = ({ tabs, onTabClick }) => {
  const [activeTab, setActiveTab] = useState<string>(tabs[0].id);

  const handleTabClick = (id: string) => {
    setActiveTab(id);
    if (onTabClick) {
      onTabClick(id);
    }
  };

  return (
    <div className="flex items-center space-x-2 bg-gray-800 p-1 rounded- w-[500px]">
      {tabs.map((tab) => (
        <button
          key={tab.id}
          onClick={() => handleTabClick(tab.id)}
          className={`px-4 py-1.5 rounded- transition-colors duration-200 ${
            activeTab === tab.id
              ? 'bg-gray-600 text-white'
              : 'text-gray-400 hover:bg-gray-700 hover:text-white'
          }`}
        >
          {tab.label}
        </button>
      ))}
    </div>
  );
};

export default Tabs;
