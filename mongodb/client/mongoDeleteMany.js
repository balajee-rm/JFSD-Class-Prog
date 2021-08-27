const { MongoClient } = require("mongodb");
// Replace the uri string with your MongoDB deployment's connection string.
const uri =
  "mongodb+srv://mongodbroot:mongodbroot@cluster0.75ksr.mongodb.net/?retryWrites=true&w=majority";
const client = new MongoClient(uri);
async function run() {
  try {
    await client.connect();
    const database = client.db("myFirstDatabase");
    const fc = database.collection("firstCollection");
    const filter = { dept: "BT1" };
    const result = await fc.deleteMany(filter);
    console.log(`documents were deleted`);
  } finally {
    await client.close();
  }
}
run().catch(console.dir);