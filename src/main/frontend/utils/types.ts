export interface CombinedData {
    id: number;                // Adjust the type if necessary
    label: string;
    value: any;               // Replace `any` with the appropriate type if you know it
    timestamp: string;         // Use Date if you want to parse it into a Date object later
    source_table: string;
}