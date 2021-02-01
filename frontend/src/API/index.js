import axios from 'axios';

export const changeLanguage = lng => { axios.defaults.headers['accept-language'] = lng; };

export const userSignUp = ({ username, displayname, password }) => new Promise(async resolve => {
	const body = { username, displayname, password };

	await axios.post('/api/v1/users', body)
		.then(res => {
			console.log(res.data);
			resolve({ status: true, data: res.data });
		})
		.catch(e => {
			console.log(e);
			resolve({ status: false, data: e });
		});
});



