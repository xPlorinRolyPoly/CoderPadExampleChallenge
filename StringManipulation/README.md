**Parse a string and turn it into an array of objects**

```
const sampleCsv = 'ACCOUNT_NUMBER,ACCOUNT_ID,DATE,SCORE,SCORE_1\n954332033,141310885,09/13/2020,92,84\n954332033,141310885,09/14/2020,74,83\n954332033,141310885,09/15/2020,94,94';
// Turn this csv string into an array of objects. 
// There is no need to import any libraries.
// Each object within the array should have a header value
// It should look like:
// [ { ACCOUNT_NUMBER: '954332033',
//    ACCOUNT_ID: '141310885',
//    DATE: '09/13/2020',
//    SCORE: '92',
//    SCORE_1: '84' },
//  { ACCOUNT_NUMBER: '954332033',
//    ACCOUNT_ID: '141310885',
//    DATE: '09/13/2020',
//    SCORE: '74',
//    SCORE_1: '83' },
//  { ACCOUNT_NUMBER: '954332033',
//    ACCOUNT_ID: '141310885',
//    DATE: '09/13/2020',
//    SCORE: '94',
//    SCORE_1: '94' } ]
```