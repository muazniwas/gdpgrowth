# gdpgrowth
Use the endpoint "/api/upload" for uploading initial data to the database.
Use a csv file to upload.

To calculate the gdp growth rate of a country by year, use the endpoint "/api/gdp-growth/{countryCode}"

Send the country code as a path variable and the year as query parameters.

Sample request
```
http://localhost:8080/api/gdp-growth/AF?fromYear=1962&toYear=1963
```

"countryCode" can be either Alpha-2 code or Alpha-3 code
