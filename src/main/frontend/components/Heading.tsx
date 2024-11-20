
import React from 'react'
import '@vaadin/icons';
import { Icon } from '@vaadin/react-components/Icon.js';
import { Tooltip } from '@vaadin/react-components';
import { useSignal } from '@vaadin/hilla-react-signals';
import { Button } from '@vaadin/react-components/Button.js';
import { Dialog } from '@vaadin/react-components/Dialog.js';
import { VerticalLayout } from '@vaadin/react-components/VerticalLayout.js';


const Heading = () => {
  const dialogOpened = useSignal(false);

  const handleOpenDialog = () => {
    dialogOpened.value = true;
  };

  return (
    <div className="w-full h-[70px] bg-primary-color flex items-center justify-between">
      <div className="ml-[10px] text-white md:text-[18px]">
        [ JROADHF Over 80 Score ]
      </div>
      <div
        className="mr-[20px] cursor-pointer"
        onClick={handleOpenDialog}
      >
        <Icon
          id="tip"
          icon="vaadin:info-circle"
          style={{ color: 'white', height: '28px', width: '28px' }}
        />
      </div>
      <Example dialogOpened={dialogOpened} />
    </div>
  );
};

export default Heading;

function Example({ dialogOpened }: { dialogOpened: { value: boolean } }) {
  const handleClose = () => {
    dialogOpened.value = false;
  };

  return (
    <Dialog
      aria-label="Description"
      opened={dialogOpened.value}
      onOpenedChanged={(event) => {
        dialogOpened.value = event.detail.value;
      }}
    >
      <VerticalLayout
        theme="spacing"
        style={{
          width: '300px',
          maxWidth: '100%',
          alignItems: 'stretch',
        }}
      >
        <h2
          style={{
            margin: 'var(--lumo-space-m) 0',
            fontSize: '1.5em',
            fontWeight: 'bold',
          }}
        >
          Description
        </h2>
        <p className='text-[16px]'>
          Estimation of 1-year and 3-years mortality in heart failure patients aged 80 years and older.
        </p>
        <Button onClick={handleClose} style={{ alignSelf: 'flex-end' }}>
          Close
        </Button>
      </VerticalLayout>
    </Dialog>
  );
}