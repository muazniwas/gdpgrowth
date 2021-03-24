# gdpgrowth
Use the endpoint "/api/upload" for uploading initial data to the database

To calculate the gdp growth rate of a country by year, use the endpoint "/api/gdp-growth"

Sample request body
{
    "countryCode": "AFG",
    "fromYear": 1962,
    "toYear": 1963
}

"countryCode" can be either Alpha-2 code or Alpha-3 code
